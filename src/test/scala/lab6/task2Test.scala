package lab6
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task2Test extends FreeSpec with ChiselScalatestTester{
  "Counterrr test" in {
    test(new task2(13)){ c =>
        c.io.out.expect(0.U)
        c.clock.step(20)
    }
  }
}