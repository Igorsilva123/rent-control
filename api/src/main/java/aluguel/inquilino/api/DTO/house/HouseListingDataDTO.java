package aluguel.inquilino.api.DTO.house;

import aluguel.inquilino.api.domain.address.Address;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.owner.Owner;
import aluguel.inquilino.api.domain.tenants.Tenants;

public record HouseListingDataDTO(Long id_house ,String rent_value, Address address, OwnerDTO owner, TenantDTO tenant) {
    public HouseListingDataDTO(House data){
        this(data.getId_house(), data.getRent_value(), data.getAddress(),new OwnerDTO(data.getOwner()), new TenantDTO(data.getTenant()));

    }

    public record OwnerDTO(Long id, String name) {
        public OwnerDTO(Owner owner) {
            this(owner.getId_owner(), owner.getName());
        }
    }

    public record TenantDTO(Long id, String name) {
        public TenantDTO(Tenants tenant) {
            this(tenant.getId_tenants(), tenant.getName());
        }
    }
}
