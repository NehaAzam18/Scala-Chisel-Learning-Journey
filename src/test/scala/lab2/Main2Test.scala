package lab2
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class Main2Test extends FreeSpec with ChiselScalatestTester{
  "4_to_1_MUX test" in {
    test(new Main2()){ c =>
        c.io.in_A.poke(20.U)
        c.io.in_B.poke(67.U)
        c.io.select.poke(1.B)
        c.io.out.expect(67.U)
        c.clock.step(1)
    }
  }
}