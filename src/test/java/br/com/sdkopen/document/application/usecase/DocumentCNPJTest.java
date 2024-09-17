package br.com.sdkopen.document.application.usecase;

import junit.framework.TestCase;

public class DocumentCNPJTest extends TestCase {

  public void testIsValid() {
    assertTrue(DocumentCNPJ.isValid("11.444.777/0001-61"));
    assertTrue(DocumentCNPJ.isValid("11444777000161"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/0001-62"));
    assertFalse(DocumentCNPJ.isValid("11444777000162"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/0001-6"));
    assertFalse(DocumentCNPJ.isValid("1144477700016"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/0001-"));
    assertFalse(DocumentCNPJ.isValid("114447770001"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/0001"));
    assertFalse(DocumentCNPJ.isValid("114447770001"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/000"));
    assertFalse(DocumentCNPJ.isValid("11444777000"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/00"));
    assertFalse(DocumentCNPJ.isValid("1144477700"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/0"));
    assertFalse(DocumentCNPJ.isValid("114447770"));
    assertFalse(DocumentCNPJ.isValid("11.444.777/"));
    assertFalse(DocumentCNPJ.isValid("11444777"));
    assertFalse(DocumentCNPJ.isValid("11.444.777"));
    assertFalse(DocumentCNPJ.isValid("1144477"));
    assertFalse(DocumentCNPJ.isValid("11.444.77"));
    assertFalse(DocumentCNPJ.isValid("114447"));
    assertFalse(DocumentCNPJ.isValid("11.444.7"));
    assertFalse(DocumentCNPJ.isValid("11444"));
    assertFalse(DocumentCNPJ.isValid("11.444"));
    assertFalse(DocumentCNPJ.isValid("1144"));
    assertFalse(DocumentCNPJ.isValid("11.44"));
    assertFalse(DocumentCNPJ.isValid("114"));
    assertFalse(DocumentCNPJ.isValid("11.4"));
    assertFalse(DocumentCNPJ.isValid("1"));
    assertFalse(DocumentCNPJ.isValid("11"));
    assertFalse(DocumentCNPJ.isValid("1"));
    assertFalse(DocumentCNPJ.isValid(""));
    assertFalse(DocumentCNPJ.isValid(null));
  }

  public void testGenerateRandom() {
    String cnpj = DocumentCNPJ.generateRandom(true);
    assertTrue(DocumentCNPJ.isValid(cnpj));
    assertEquals(18, cnpj.length());

    cnpj = DocumentCNPJ.generateRandom(false);
    assertTrue(DocumentCNPJ.isValid(cnpj));
    assertEquals(14, cnpj.length());
  }
}