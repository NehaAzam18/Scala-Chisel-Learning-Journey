package lab1
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task3Test extends FreeSpec with ChiselScalatestTester{
  "counterBit test" in {
    test(new task3(10, 100)){ c =>
      c.clock.step(300)
    }
  }
}