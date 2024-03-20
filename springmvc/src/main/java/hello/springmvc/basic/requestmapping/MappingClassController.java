package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * 회원 목록 조회: GET /users
     * 회원 등록: POST /users
     * 회원 조회: GET /users/{userId}
     * 회원 수정: PATCH /users/{userId}
     * 회원 삭제: DELETE /users/{userId}
     */

    public String user() {
        return "get users";
    }

    public String addUser() {
        return "post user";
    }

    @GetMapping(value = "/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get user = " + userId;
    }

    @PatchMapping (value = "/{userId}")
    public String updatedUser(@PathVariable String userId) {
        return "update user = " + userId;
    }

    @DeleteMapping (value = "/{userId}")
    public String deletedUser(@PathVariable String userId) {
        return "delete user = " + userId;
    }


}
