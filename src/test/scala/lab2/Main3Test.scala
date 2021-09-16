package lab2
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class Main3Test extends FreeSpec with ChiselScalatestTester{
  "4_to_1_MUX test" in {
    test(new Main3){ c =>
        c.io.in0.poke(1.B)
        c.io.in1.poke(0.B)
        c.io.in2.poke(0.B)
        c.io.in3.poke(1.B)
        c.io.in4.poke(0.B)
        c.io.in5.poke(1.B)
        c.io.in6.poke(0.B)
        c.io.in7.poke(0.B)
        c.io.sel0.poke(1.U)
        c.io.sel1.poke(1.U)
        c.io.sel2.poke(1.U)
        c.io.out.expect(0.B)
        c.clock.step(1)
    }
  }
}