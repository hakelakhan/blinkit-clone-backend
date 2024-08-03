package org.example.dto;

import java.util.List;

public record CartDTO

        (
                List<CartItemDTO> cartItems
        ){
}
