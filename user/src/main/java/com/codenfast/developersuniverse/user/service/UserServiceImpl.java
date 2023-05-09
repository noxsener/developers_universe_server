package com.codenfast.developersuniverse.user.service;

import com.codenfast.developersuniverse.common.entity.user.*;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.model.*;
import com.codenfast.developersuniverse.user.repository.*;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService, UserDetailsService {

    private final UserRepository repository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final AuthRepository authRepository;
    private final RoleAuthRepository roleAuthRepository;
    private final UserAuthRepository userAuthRepository;
    private final ObjectMapper objectMapper;

    @Override
    public User save(User entity) throws CodenfastException {
        User entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public User update(User entity) throws CodenfastException {
        User entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public User delete(String id) throws CodenfastException {
        Optional<User> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        User entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<User> save(List<User> entityList) throws CodenfastException {
        List<User> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<User> update(List<User> entityList) throws CodenfastException {
        List<User> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<User> delete(List<User> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(User::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(User.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(User.class, repository, requestGrid);
    }

    @Override
    public TableModel<User> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(User.class, repository, requestGrid);
    }

    @Override
    public User login(LoginUserModel loginUserModel) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User loginByToken(LoginUserModel loginUserModel) {
        try {
            String payloadBase64 = loginUserModel.getRefreshToken().split("[.]")[1];
            String payload = new String(Base64.getDecoder().decode(payloadBase64), StandardCharsets.UTF_8);
            Map jwtClaimsSet = objectMapper.readValue(payload, Map.class);
            RequestGrid requestGrid = new RequestGrid();
            requestGrid.setPage(0);
            requestGrid.setPageSize(1);
            requestGrid.setFilters(Collections.singletonList(new FilterParam("username", StringConstant.EQUAL, jwtClaimsSet.get("sub"))));
            List<User> userList = grid(requestGrid);
            return !CollectionUtils.isEmpty(userList) ? userList.get(0) : null;
        } catch (IOException | CodenfastException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            List<User> userList = repository.grid(User.class, Arrays.asList("id","username","password","name","surname","passive"),
                    0, 1, null, null, Collections.singletonList(new FilterParam("username", StringConstant.EQUAL, username)));
            if (CollectionUtils.isEmpty(userList)) {
                throw new UsernameNotFoundException("User/Password is invalid: "+username);
            }
            User user = userList.get(0);

            List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();
            if (!user.getPassive()) {
                Set<String> grantSet = new HashSet<>();
                try {
                    List<UserRole> userRoleList = userRoleRepository.grid(
                            UserRole.class, null,
                            Arrays.asList(
                                    new FilterParam("user.id", StringConstant.EQUAL, user.getId()),
                                    new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE)
                            ));
                    for (UserRole userRole : userRoleList) {
                        List<Auth> authList = getUserRoleAuthorizations(userRole);
                        for (Auth auth : authList) {
                            grantSet.add(auth.getName());
                        }
                    }

                    List<UserAuth> userAuthList = userAuthRepository.grid(
                            UserAuth.class, Arrays.asList("id", "auth"),
                            Arrays.asList(
                                    new FilterParam("user.id", StringConstant.EQUAL, user.getId()),
                                    new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE)
                            ));
                    for (UserAuth userAuth : userAuthList) {
                        if (userAuth.getAuth().getGrantDirection()) {
                            grantSet.add(userAuth.getGrantName());
                        } else {
                            grantSet.remove(userAuth.getGrantName());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                grantedAuthorityList = grantSet.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            }

                return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    !user.getPassive(),
                    !user.getPassive(),
                    !user.getPassive(),
                    !user.getPassive(),
                    grantedAuthorityList
                    );
        } catch (NoSuchFieldException | IOException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new UsernameNotFoundException("User not found: "+username);
        }
    }

    private List<Auth> getUserRoleAuthorizations(UserRole userRole) {
        if (ObjectUtils.isEmpty(userRole)) {
            return Collections.emptyList();
        }
        try {
            if (ObjectUtils.isEmpty(userRole.getRole())) {
                return Collections.emptyList();
            }
            List<RoleAuth> roleAuthList = roleAuthRepository.grid(RoleAuth.class, Arrays.asList("id", "auth"), null, null,
                    Arrays.asList(
                            new FilterParam("role.id", StringConstant.EQUAL, userRole.getRole().getId()),
                            new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE)
                    ));
            return roleAuthList.stream().map(RoleAuth::getAuth).collect(Collectors.toList());
        } catch (NoSuchFieldException | IOException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            return Collections.emptyList();
        }
    }
}
