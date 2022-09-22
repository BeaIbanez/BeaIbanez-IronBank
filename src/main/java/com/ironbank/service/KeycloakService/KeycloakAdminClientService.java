package com.ironbank.service.KeycloakService;



import com.ironbank.configuration.KeycloakProvider;
import com.ironbank.http.requestUser.CreateUserRequest;
import com.ironbank.model.users.AccountHolder;
import com.ironbank.model.users.Address;
import com.ironbank.service.users.AccountHolderService;
import lombok.extern.java.Log;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Service
@Log
public class KeycloakAdminClientService {
    private final KeycloakProvider kcProvider;

    private final AccountHolderService accountHolderService;
    @Value("${keycloak.realm}")
    public String realm;
    @Value(("${keycloak.resource}"))
    public String clientId;


    public KeycloakAdminClientService(KeycloakProvider keycloakProvider, AccountHolderService accountHolderService) {
        this.kcProvider = keycloakProvider;
        this.accountHolderService = accountHolderService;
    }

    private static CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }

    public Response createKeycloakUser(CreateUserRequest user) {
        var adminKeycloak = kcProvider.getInstance();
        UsersResource usersResource = kcProvider.getInstance().realm(realm).users();
        CredentialRepresentation credentialRepresentation = createPasswordCredentials(user.getPassword());

        UserRepresentation kcUser = new UserRepresentation();
        kcUser.setUsername(user.getEmail());
        kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
        kcUser.setFirstName(user.getFirstname());
        kcUser.setLastName(user.getLastname());
        kcUser.setEmail(user.getEmail());
        kcUser.setEnabled(true);
        kcUser.setEmailVerified(false);

//        Change this to change the group logic
        kcUser.setGroups(List.of("members"));


        Response response = usersResource.create(kcUser);
//USER
        if (response.getStatus() == 201) {
            List<UserRepresentation> userList = adminKeycloak.realm(realm).users().search(kcUser.getUsername()).stream()
                    .filter(userRep -> userRep.getUsername().equals(kcUser.getUsername())).toList();
            var createdUser = userList.get(0);
            log.info("User with id: " + createdUser.getId() + " created");

//ACCOUNTHOLDER
//TODO CREAR ACCOUNT HOLDER PARA LA BBDD - Todos sus atributos
        var accountHolder = new AccountHolder();
        accountHolder.setName(user.getFirstname());
        accountHolder.setEmail(user.getEmail());
        accountHolder.setAddress(new Address(21,"salaBoadella","spain",199L)); //TODO
        accountHolder.setDateOfBirth(LocalDate.now());

        var createdAccountHolder = accountHolderService.create(accountHolder);
        log.info("Account Holder:" + createdAccountHolder + "has been created");
        }
        return response;

    }
//ADMIN


}
