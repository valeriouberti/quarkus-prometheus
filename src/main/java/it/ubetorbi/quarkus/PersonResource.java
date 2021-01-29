package it.ubetorbi.quarkus;

import it.ubetorbi.quarkus.domain.Person;
import it.ubetorbi.quarkus.repository.PersonRepository;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.Optional;

@Path("/person/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {


    @Inject
    PersonRepository personRepository;

    @GET
    @Path("{name}")
    @Counted(name = "countGetPersonByName",
            description = "Counts how many times the getPersonByName method has been invoked")
    @Timed(name = "timeGetPersonByName",
            description = "Times how long it takes to invoke the getPersonByName method",
            unit = MetricUnits.MILLISECONDS)
    public Response getPersonByName(@PathParam("name")String name) {

        Optional<Person> person = personRepository.findByName(name);
        if(person.isPresent()){
            return Response.ok(person.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @GET
    @Gauge(name = "gaugeCountAllPersons",
            description = "Instantaneous time of the countAllPeople method",
            unit = "correctness")
    public Long countAllPeople() {
        return personRepository.count();
    }

    @GET
    @Path("{id}")
    @Metered(name = "meteredGetPersonById",
            description = "Measures throughput of the getPersonById method")
    public Response getPersonById(@PathParam("id") String id){
        Optional<Person> person = personRepository.findByIdOptional(id);
        if(person.isPresent()){
            return Response.ok(person.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("insert")
    @Counted(name = "countInsertPerson",
            description = "Counts how many times the insertPerson method has been invoked")
    public Response insertPerson(Person person){
        personRepository.persist(person);
        return Response.ok(Map.of("Saved", person)).build();
    }
}