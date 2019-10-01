import static java.util.stream.Collectors.averagingLong;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Test {

  public static void main(String[] args) {
//
//    Map<String, Long> map = new HashMap<>();
//
//    List<Crit> crits = Arrays.asList(
//        new Crit(null, 100l),
//        new Crit('D', 500l),
//        new Crit('D', 20l),
//        new Crit('M', 40l),
//        new Crit('M', 60l),
//        new Crit('D', 10l),
//        new Crit(null, 1l),
//        new Crit(null, 0l),
//        new Crit(null, 300l),
//        new Crit(null, 100l)
//    );
//
//    Map<Character, Long> collect = crits
//        .stream()
//        .collect(
//            groupingBy(
//            c -> c.getCritType() == null ? 'A' : c.getCritType(),
//            summingLong(Crit::getBid))
//        );
//
//    System.out.println("Plus Size Clothes Subscription".length());

    String sort = "test";

    String[] split = sort.split(", ");

    for (String s : split) {
      System.out.println(s);
    }

  }


  public void testFuture(){
    CompletableFuture<String> future ;
  }



  interface Adapter {

    public void adapt(Ad ad);
  }


  class Ad_Adapter implements Adapter{

    @Override
    public void adapt(Ad ad) {

    }


    void adaptInternal(Ad_B ad_b) {

    }

    void adaptInternal(Ad_C ad_c) {

    }

    void adaptInternal(Ad_D ad_d) {

    }

  }


  class Ad {
  }

  class Ad_B extends Ad{
    String b;
  }

  class Ad_C extends Ad{
    String c;
  }

  class Ad_D extends Ad{
    String d;
  }

  static class Crit {

    public Character critType;
    public Long bid;

    public Crit(Character critType, Long bid) {
      this.critType = critType;
      this.bid = bid;
    }

    public Character getCritType() {
      return critType;
    }

    public void setCritType(Character critType) {
      this.critType = critType;
    }

    public Long getBid() {
      return bid;
    }

    public void setBid(Long bid) {
      this.bid = bid;
    }
  }


}
