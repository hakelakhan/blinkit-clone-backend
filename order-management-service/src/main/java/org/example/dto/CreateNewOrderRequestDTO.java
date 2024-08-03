package org.example.dto;

import java.util.List;

public record CreateNewOrderRequestDTO
        (
                String customerHandleNumber,
                CartDTO cartDTO,
                String optionalNote
         )
{}
