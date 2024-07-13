package com.example.ERP.Mappers;

import org.springframework.stereotype.Component;

import com.example.ERP.Dto.RouteDTO;
import com.example.ERP.Models.Route;


@Component
public class RouteMapper {
    public static RouteDTO toDTO(Route route) {
        return new RouteDTO(
                route.getId(),
                route.getOrigin(),
                route.getDestination(),
                route.getDistance(),
                route.getShipment() != null ? route.getShipment().getId() : null
        );
    }

    public static Route toEntity(RouteDTO routeDTO) {
        Route route = new Route();
        route.setId(routeDTO.getId());
        route.setOrigin(routeDTO.getOrigin());
        route.setDestination(routeDTO.getDestination());
        route.setDistance(routeDTO.getDistance());
        // shipment should be set by service layer or ORM relationships
        return route;
    }
}
