package lab2
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class Main6Test extends FreeSpec with ChiselScalatestTester{
  "4Bit_BarrelShifter test" in {
    test(new Main6()){ c =>
        c.io.in0.poke(1.B)
        c.io.in1.poke(0.B)
        c.io.in2.poke(1.B)
        c.io.in3.poke(0.B)
        c.io.sel1(0).poke(0.B)
        c.io.sel1(1).poke(0.B)
        c.io.shift_type.poke(0.B)
        c.io.out0.expect(1.B)
        c.io.out1.expect(0.B)
        c.io.out2.expect(1.B)
        c.io.out3.expect(0.B)
        c.clock.step(1)
    }
  }
}