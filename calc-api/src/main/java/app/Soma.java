package app;

import io.jooby.annotations.GET;
import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

public class Soma {
    
    @Path("/soma/{op1}/{op2}")
    @GET
    public String rotaSoma(@PathParam String op1, @PathParam String op2){

        try {
            
            double num1 = Double.parseDouble(op1);
            double num2 = Double.parseDouble(op2);
            double soma = num1 + num2;
            
            return Double.toString(soma);
            
        } catch (NumberFormatException nfe) {
            
            if(verificacaoDeNumero(op1) && verificacaoDeNumero(op2) == false){

                throw new BadRequestException(String.format("Parâmetro inválido: \\%s ", op1));

            }else if(verificacaoDeNumero(op1) == false && verificacaoDeNumero(op2)){

                throw new BadRequestException(String.format("Parâmetro inválido: \\%s", op2));

            }

            throw new BadRequestException(String.format("Parâmetros inválidos: \\%s\\%s", op1, op2));
        }
        
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
