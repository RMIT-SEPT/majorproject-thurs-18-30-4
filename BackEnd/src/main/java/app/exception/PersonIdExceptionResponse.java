package app.exception;
// exception class for  person ID
public class PersonIdExceptionResponse {
    private String personIdentifier;
    //constructor for the exception response regarding person id
    public PersonIdExceptionResponse(String projectIdentifier) {
        this.personIdentifier = projectIdentifier;
    }
    //getter for person ID
    public String getPersonIdentifier() {
        return personIdentifier;
    }
    //setter for person ID
    public void setPersonIdentifier(String personIdentifier) {
        this.personIdentifier = personIdentifier;
    }
}
