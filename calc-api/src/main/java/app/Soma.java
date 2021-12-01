package app;

import io.jooby.annotations.GET;
import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

public class Soma {
    
    @Path("/soma/{op1}/{op2}")
    @GET
    public String rotaSoma(@PathParam String a, @PathParam String b) throws BadRequestException {
        try {
            double soma = soma(a,b);

            return String.format("%.2f", soma);
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException(iae.getMessage());
        }
    }

    public double soma(String a, String b) throws IllegalArgumentException {
        double soma;

        try {
            soma = Double.parseDouble(a) + Double.parseDouble(b);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(String.format("Parâmetros inválidos: %s e %s.", a, b));
        }

        if(verificacaoDeNumero(a) && verificacaoDeNumero(b) == false){
            throw new IllegalArgumentException(String.format("Parâmetro inválido: %s", a));
        } else if(verificacaoDeNumero(a) == false && verificacaoDeNumero(b)){
            throw new IllegalArgumentException(String.format("Parâmetro inválido: %s", b));
        } 

        return soma;
    }

    private Boolean verificacaoDeNumero(String num){
        try {
            Double.parseDouble(num);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }
}
