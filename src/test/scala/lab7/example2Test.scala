package lab7
import chisel3._ 
import org.scalatest._
import chiseltest._

import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotationAnnotation

class example2Test extends FreeSpec with ChiselScalatestTester{
  "CounterUpDown test" in {
    test(new example2(8)){ c =>
    c.io.data_in.poke(16.U)
    c.clock.step(40)
    }
  }
}
