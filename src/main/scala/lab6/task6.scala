//Counter with XOR example
package lab6
import chisel3 . _
import chisel3 . util . _
class task6 ( val max : Int = 1) extends Module {
val io = IO ( new Bundle {
val out = Output ( UInt (( log2Ceil ( max ) . W ) ) )
})
val counter = RegInit ( 0 . U ( log2Ceil ( max ) . W ) )
val count_buffer = if ( isPow2 ( max ) ) counter + 1. U
else Mux ( counter === max .U , counter ^ 1.U , counter + 1. U )
counter := count_buffer
io . out := counter(1)
}

// when(count === max){
//     io.out := max ^ 1
// }.otherwise{
//     io.out := count + 1
// }
// counter := count_buffer
// io . out := count

// Start Coding here