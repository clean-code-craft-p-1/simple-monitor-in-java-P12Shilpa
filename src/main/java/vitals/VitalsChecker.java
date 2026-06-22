package vitals;


public abstract class VitalsChecker {
  private static void alertBlink() throws InterruptedException {
    for (int i = 0; i < 6; i++) {
      System.out.print("\r* ");
      Thread.sleep(1000);
      System.out.print("\r *");
      Thread.sleep(1000);
    }
  }

  static boolean vitalsOk(float temperature, float pulseRate, float spo2) 
      throws InterruptedException {
    if (temperature > 102 || temperature < 95) {
      System.out.println("Temperature is critical!");
      alertBlink();
      return false;
    } else if (pulseRate < 60 || pulseRate > 100) {
      System.out.println("Pulse Rate is out of range!");
      alertBlink();
      return false;
    } else if (spo2 < 90) {
      System.out.println("Oxygen Saturation out of range!");
      alertBlink();
      return false;
    }
    return true;
  }
}
