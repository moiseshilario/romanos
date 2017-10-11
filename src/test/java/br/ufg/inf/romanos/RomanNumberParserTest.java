package br.ufg.inf.romanos;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumberParserTest {

    String romanNumber = "MMMDCCCLXXXVIII";
    String romanNumber2 = "MMMCMXCIX";

    @Test
    public void testUpperLimit_3999(){
        String romanNumber = "MMMCMXCIX";
        Assert.assertEquals(3999, RomanNumberParser.romanoParaInteiro(romanNumber));
    }

    @Test
    public void testLowerLimit_1(){
        String romanNumber = "I";
        Assert.assertEquals(1, RomanNumberParser.romanoParaInteiro(romanNumber));
    }

    @Test
    public void testHighestCharLengthNumber_3888()  {
        String romanNumber = "MMMDCCCLXXXVIII";
        
        Assert.assertEquals(3888, RomanNumberParser.romanoParaInteiro(romanNumber));
    }

    @Test 
    public void testQuantidadeDeNumerosIlegais() {
        String romanNumber = "IIII";
        String romanNumber2 = "VV";
        String romanNumber3 = "XXXX";
        String romanNumber4 = "LL";
        String romanNumber5 = "CCCC";
        String romanNumber6 = "DD";
        String romanNumber7 = "MMMM";
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber));
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber2));
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber3));
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber4));
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber5));
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber6));
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber7));
    }
    
    @Test 
    public void testQuantidadeDeNumerosValidos() {
        String romanNumber = "III";
        
        Assert.assertTrue(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber));
    }
    
    @Test 
    public void testNumerosNaoExistente() {
        String romanNumber = "K";
        
        Assert.assertFalse(RomanNumberParser.validarQuantidadeDeDigitos(romanNumber));
    }
    
    @Test 
    public void testSeEhRomano() {
        String num = "IL";
        String num2 = "XX";
       
        Assert.assertFalse(RomanNumberParser.ehRomano(num));
        Assert.assertTrue(RomanNumberParser.ehRomano(num2));
    }
    
    
}
