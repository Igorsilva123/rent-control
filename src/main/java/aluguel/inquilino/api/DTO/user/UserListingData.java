package aluguel.inquilino.api.DTO.user;

import aluguel.inquilino.api.domain.user.User;

public record UserListingData(Long id, String name, String nickName) {
    public UserListingData(User user) {
        this(user.getId(), user.getName(), user.getNickName());
    }
}
