package com.quarks.demo.credit.card.api.exceptions.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class QuarksCustomExceptionHandler  implements ExceptionMapper<Throwable>
{
    @Override
    public Response toResponse(Throwable exception) 
    {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
    }


}


