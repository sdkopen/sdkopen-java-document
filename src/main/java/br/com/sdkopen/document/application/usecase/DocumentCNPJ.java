package br.com.sdkopen.document.application.usecase;

import java.util.Random;

public class DocumentCNPJ {

  public static final String CNPJ_FORMAT = "%s.%s.%s/%s-%s";

  public static boolean isValid(String cnpj) {
    if (cnpj == null) {
      return false;
    }

    cnpj = cnpj.replaceAll("\\D", "");

    if (cnpj.length() != 14) {
      return false;
    }

    if (cnpj.chars().distinct().count() == 1) {
      return false;
    }

    char dig13 = calculateCheckDigit(cnpj, 12);
    char dig14 = calculateCheckDigit(cnpj, 13);

    return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
  }

  public static String generateRandom(boolean formatted) {
    Random random = new Random();

    StringBuilder cnpj = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      cnpj.append(random.nextInt(10));
    }

    for (int i = 0; i < 4; i++) {
      cnpj.append(random.nextInt(10));
    }

    cnpj.append(calculateCheckDigit(cnpj.toString(), 12));
    cnpj.append(calculateCheckDigit(cnpj.toString(), 13));

    if (formatted) {
      return String.format(CNPJ_FORMAT,
          cnpj.substring(0, 2), cnpj.substring(2, 5), cnpj.substring(5, 8),
          cnpj.substring(8, 12), cnpj.substring(12, 14));
    } else {
      return cnpj.toString();
    }
  }

  private static char calculateCheckDigit(String cnpj, int length) {
    int[] weights = length == 12
        ? new int[] {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}
        : new int[] {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    int sum = 0;
    for (int i = 0; i < length; i++) {
      sum += (cnpj.charAt(i) - '0') * weights[i];
    }

    int remainder = sum % 11;
    return (remainder < 2) ? '0' : (char) ((11 - remainder) + '0');
  }
}
