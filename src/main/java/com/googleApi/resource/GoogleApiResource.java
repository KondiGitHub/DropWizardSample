package com.googleApi.resource;

import com.googleApi.model.dto.google_news.GoogleResponse;
import com.googleApi.services.GoogleNewsService;
import io.swagger.annotations.*;
import com.googleApi.serviceProviders.GoogleNewsCommand;
import com.googleApi.serviceProviders.GoogleNewsSearchCommand;
import com.googleApi.services.GoogleNewsSearchService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/news")
@Produces(MediaType.APPLICATION_JSON)
@Api(value ="/news: to get latest news", description = "Sample Dropwizard Service")
public class GoogleApiResource {

    private GoogleNewsService googleNewsService;
    private GoogleNewsSearchService googleNewsSearchService;
    public GoogleApiResource(GoogleNewsService googleService, GoogleNewsSearchService googleNewsSearchService) {
        this.googleNewsService = googleService;
        this.googleNewsSearchService = googleNewsSearchService;
    }

    @GET
    @Path("/today")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Produce latest news", response = GoogleResponse.class)
    @ApiResponses({
            @ApiResponse(code=200, response = GoogleResponse.class, message = "Display latest news")
    })
    public Response getTodayNews(@Context HttpServletRequest httpServletRequest) throws IOException {
        GoogleNewsCommand googleNewsCommand = new GoogleNewsCommand(googleNewsService);
        return Response.status(Response.Status.OK).entity(googleNewsCommand.execute()).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Produce search based news", response = GoogleResponse.class)
    @ApiResponses({
            @ApiResponse(code=200, response = GoogleResponse.class, message = "Display search based news")})
    public Response getSearchResults(@Context HttpServletRequest httpServletRequest,
                                     @ApiParam(required = true, value= "search string",defaultValue ="love" )
                                     @QueryParam("searchString") String searchTerm) throws IOException {
        GoogleNewsSearchCommand googleNewsCommand = new GoogleNewsSearchCommand(googleNewsSearchService,searchTerm);
        return Response.status(Response.Status.OK).entity(googleNewsCommand.execute()).build();
    }
}
