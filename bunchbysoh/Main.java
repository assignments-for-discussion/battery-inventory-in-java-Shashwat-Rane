package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for(int presentCapacity:presentCapacities)
      {
        double SoH = 100 * presentCapacity /120.0;
        if(SoH>80 && SoH<=100)
           counts.healthy++;
        else if(SoH>=62 && SoH<=80)
           counts.exchange++;
        else
          counts.failed++;
           
      }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);

    int[] allHealthy = {120,120,120,120,120,120};
    CountsBySoH allHealthycounts = countBatteriesByHealth(allHealthy);
    assert(allHealthycounts.healthy == 6);
    assert(allHealthycounts.exchange == 0);
    assert(allHealthycounts.failed == 0);
    
    int[] allFailed = {0,5,10,2,4,6,7,11,32};
    CountsBySoH allFailedcounts = countBatteriesByHealth(allFailed);
    assert(allFailedcounts.healthy == 0);
    assert(allFailedcounts.exchange == 0);
    assert(allFailedcounts.failed == 9);

    int[] allFailed = {0,62,80,100};
    CountsBySoH allFailedcounts = countBatteriesByHealth(allFailed);
    assert(allFailedcounts.healthy == 1);
    assert(allFailedcounts.exchange == 1);
    assert(allFailedcounts.failed == 2);
   
    
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
