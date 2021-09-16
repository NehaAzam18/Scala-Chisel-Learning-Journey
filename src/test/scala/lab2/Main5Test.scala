package lab2
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class Main5Test extends FreeSpec with ChiselScalatestTester{
  "4Bit_BarrelShifter test" in {
    test(new Main5()){ c =>
        c.io.s0.poke(1.B)
        c.io.s1.poke(0.B)
        c.io.s2.poke(0.B)
        c.io.out.expect(8.U)
        c.clock.step(1)
    }
  }
}