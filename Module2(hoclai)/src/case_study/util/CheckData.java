package case_study.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckData {
 public static boolean isValiCode(String code){
  Pattern pattern = Pattern.compile("^NV-\\d{4}$");
  Matcher matcher = pattern.matcher(code);
  return matcher.matches();
 }
 public static boolean isValidName(String name) {
  Pattern pattern = Pattern.compile("^[A-Z][a-z]*( [A-Z][a-z]*)*$");
  Matcher matcher = pattern.matcher(name);
  return matcher.matches();
 }
 public static boolean isValidIdCard(String idCard) {
  Pattern pattern = Pattern.compile("^\\d{9}$|^\\d{12}$");
  Matcher matcher = pattern.matcher(idCard);
  return matcher.matches();
 }
 public static boolean isValidPhoneNumber(String phoneNumber) {
  Pattern pattern = Pattern.compile("^0\\d{9}$");
  Matcher matcher = pattern.matcher(phoneNumber);
  return matcher.matches();
 }
 public static boolean isValidBirthDate(String birthDateStr) {
  Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
  Matcher matcher = pattern.matcher(birthDateStr);

  if (!matcher.matches()) {
   return false; // Định dạng không phù hợp
  }

  try {
   LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
   LocalDate now = LocalDate.now();
   return birthDate.plusYears(18).isBefore(now);
  } catch (Exception e) {
   return false;
  }
 }
 public static boolean isValidSalary(int salary) {
  return salary > 0;
 }

}
