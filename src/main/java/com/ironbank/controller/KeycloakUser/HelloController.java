package com.ironbank.controller.KeycloakUser;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/public/hello")
    public ResponseEntity<String> helloPublic() {
        return ResponseEntity.ok("Hello public user");
    }



    @GetMapping("/members/hello")
    public ResponseEntity<String> helloMember(Principal principal) {

        return ResponseEntity.ok("Hello dear member" + principal.getName());
    }

    @GetMapping("/s/hello")
    public ResponseEntity<String> helloModerator() {
        return ResponseEntity.ok("Hello Moderator");
    }


    @GetMapping("/admins/hello")
    public ResponseEntity<String> helloAdmin() {
        return ResponseEntity.ok("Nice day, admin");
    }

    @RolesAllowed("member")
    @GetMapping("/public/hello-fake-public")
    public ResponseEntity<String> helloCustom() {
        return ResponseEntity.ok("Nice day, it appears to be public but not");
    }


}
