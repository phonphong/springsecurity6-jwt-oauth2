package security.jwt.oauth2.mapper;

import lombok.Data;
import security.jwt.oauth2.dtos.UserDto;
import security.jwt.oauth2.entity.User;

@Data
public class UserMapper {
    public static UserDto mapUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
