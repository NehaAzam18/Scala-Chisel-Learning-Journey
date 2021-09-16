package lab2
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class Main4Test extends FreeSpec with ChiselScalatestTester{
  "4_to_2_MUX1H test" in {
    test(new Main4()){ c =>
        c.io.in0.poke(0.B)
        c.io.in1.poke(1.B)
        c.io.in2.poke(0.B)
        c.io.in3.poke(1.B)
        c.io.out.expect(3.U)
        c.clock.step(1)
    }
  }
}