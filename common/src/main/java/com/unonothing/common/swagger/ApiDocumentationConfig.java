package com.unonothing.common.swagger;


import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "project to practice best practices",
                version = "v1",
                title = "project20180921",
                contact = @Contact(
                        name = "uNoNothing",
                        email = "uNoNothing@users.noreply.github.com",
                        url = "https://github.com/uNoNothing/project20180921"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://github.com/uNoNothing/project20180921/blob/master/LICENSE"
                )
        ),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "https://github.com/uNoNothing/project20180921")
)
public class ApiDocumentationConfig {
}
