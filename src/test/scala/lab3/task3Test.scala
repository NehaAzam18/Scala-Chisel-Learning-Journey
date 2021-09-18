package lab3
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task3Test extends FreeSpec with ChiselScalatestTester{
  "branchControl test" in {
    test(new task3()){ c =>
        c.io.fnct3.poke("b001".U)
        c.io.arg_x.poke(3.U)
        c.io.arg_y.poke(2.U)
        c.io.branch.poke(0.B)
        c.io.br_taken.expect(0.B)
        c.clock.step(1)
    }
  }
}