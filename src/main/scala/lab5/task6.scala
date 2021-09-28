package lab5
import chisel3 . _
import chisel3 . util . _
//import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }


class dpackets [ T <: Data ]( gen : T ) extends Bundle {
val addr = UInt(10. W )
val databit = gen
}
class task6 [ T <: Data ]( gen : T ) extends Module {
val io = IO ( new Bundle{
    val in = Input(new dpackets(gen))
    val out = Output(new dpackets(gen))
} )
io . out <> io.in
}
// class Interface [ T <: Data ](params : dpackets) extends Bundle{
//     val in = Input(params.databits)
//     val add =Input(params.address)
//     val out = Output(params.databits)
// }


