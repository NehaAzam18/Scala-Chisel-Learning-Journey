package lab6
import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class task6Test extends FreeSpec with ChiselScalatestTester{
  "Counterr test" in {
    test(new task6(4)){ c =>
        c.io.out.expect(0.U)
        c.clock.step(1)
    }
  }
}