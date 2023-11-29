package tn.esprit.spring.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("4TWIN6-Swagger")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        return new Contact().name("4TWIN6")
                .email("esprit2324-4twin6@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
    }

    @Bean
    public GroupedOpenApi blocApi() {
        return GroupedOpenApi.builder()
                .group("bloc")
                .pathsToMatch(

                        "api/blocs/ChambresABloc",
                        "/api/blocs/allblocs",
                        "/api/blocs/addBloc",
                        "/api/blocs/addBlocs",
                        "/api/blocs/editbloc/{id}",
                        "/api/blocs/{id}",
                        "/api/blocs/findBlocById/{id}",
                        "/api/blocs/deleteBloc/{id}",
                        "/api/blocs/ByNomBloc/{nomBloc}",
                        "/api/blocs/ByCapaciteBloc/{capaciteBloc}",
                        "/api/blocs/byNomBlocAndCapaciteBloc",
                        "/api/blocs/byNomBlocIgnoreCase",
                        "/api/blocs/byCapaciteGreaterThan",
                        "/api/blocs/byNomBlocContaining",
                        "/api/blocs/orderByNomBlocAsc",
                        "/api/blocs/byNomBlocOrCapaciteBloc",
                        "/api/blocs/byFoyer",
                        "/api/blocs/affecterBlocAFoyer"



                )
                .build();
    }


    @Bean
    public GroupedOpenApi chambreApi() {
        return GroupedOpenApi.builder()
                .group("chambre")
                .pathsToMatch(
                        "/api/chambres/add",
                        "/api/chambres/editbyid/{id}",
                        "/api/chambres/addchambres/{chambres}",
                        "/api/chambres/delete/{id}",
                        "/api/chambres/all",
                        "/api/chambres/{id}"

                )
                .build();
    }


    @Bean
    public GroupedOpenApi etudiantsApi() {
        return GroupedOpenApi.builder()
                .group("etudiants")
                .pathsToMatch(
                        "/api/etudiants/add",
                        "/api/etudiants/edit/{id}",
                        "/api/etudiants/addEtudiants/{chambres}",
                        "/api/etudiants/delete/{id}",
                        "/api/etudiants/all",
                        "/api/etudiants/{id}"
                )
                .build();
    }



    @Bean
    public GroupedOpenApi foyerApi() {
        return GroupedOpenApi.builder()
                .group("foyer")
                .pathsToMatch(
                        "/api/foyers/add",
                        "/api/foyers/edit/{id}",
                        "/api/foyers/addFoyers",
                        "/api/foyers/all",
                        "/api/foyers/{id}",
                        "/api/foyers/delete/{id}"

                )
                .build();
    }





    @Bean
    public GroupedOpenApi universiteApi() {
        return GroupedOpenApi.builder()
                .group("universite")
                .pathsToMatch(
                        "/api/universites/all",
                        "/api/universites/findbyId/{id}",
                        "/api/universites/add",
                        "/api/universites/editById/{id}",
                        "/api/universites/deleteById/{id}",
                        "/api/universites/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}",
                        "/api/universites/desaffecterFoyerAUniversite/{idUniversite}"

                )
                .build();
    }
    @Bean
    public GroupedOpenApi reservationApi() {
        return GroupedOpenApi.builder()
                .group("reservation")
                .pathsToMatch(
                        "/api/reservations/all",
                        "/api/reservations/{id}",
                        "/api/reservations/add",
                        "/api/reservations/edit/{id}",
                        "/api/reservations/delete/{id}",
                        "/api/reservations/estvalide",
                        "/api/reservations/findbyetudiant/{id}",
                        "/api/reservations/anneeuniversitaireetvalide/{annee}"

                )
                .build();
    }
}



/*
                        "/api/blocs/allblocs",
                        "/api/blocs/addBloc",
                        "/api/blocs/addBlocs",
                        "/api/blocs/editbloc/{id}",
                        "/api/blocs/{id}",
                        "/api/blocs/findBlocById/{id}",
                        "/api/blocs/deleteBloc/{id}",
                         "/api/blocs/ByNomBloc/{nomBloc}",
                        "/api/blocs/ByCapaciteBloc/{capaciteBloc}",
                        "/api/blocs/byNomBlocAndCapaciteBloc",
                        "/api/blocs/byNomBlocIgnoreCase",
                        "/api/blocs/byCapaciteGreaterThan",
                        "/api/blocs/byNomBlocContaining",
                        "/api/blocs/orderByNomBlocAsc",
                        "/api/blocs/byNomBlocOrCapaciteBloc",
                        "/api/blocs/byFoyer",


*/
