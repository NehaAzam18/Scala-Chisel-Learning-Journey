package lab3
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester{
  "4_to_2_Encoder test" in {
    test(new task2()){ c =>
        c.io.in_A.poke(2.U)
        c.io.in_B.poke(1.U)
        c.io.alu_Op.poke(3.U)
        c.io.out.expect(2.U)
        c.io.sum.expect(2.U)
        c.clock.step(1)
    }
  }
}