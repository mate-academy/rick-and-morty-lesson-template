package mate.academy.rick_and_morty.dto;

import lombok.Data;

@Data
public class ApiResponseInfo {
  private long count;
  private String next;
  private int pages;
  private String prev;
}
