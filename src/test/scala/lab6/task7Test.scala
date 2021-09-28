package lab6
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task7Test extends FreeSpec with ChiselScalatestTester{
  "up_down_counter test" in {
    test(new task7(5)){ c =>
        c.io.out.expect(0.U)
        c.io.up_down.poke(1.B)
        c.clock.step(1)
    }
  }
}