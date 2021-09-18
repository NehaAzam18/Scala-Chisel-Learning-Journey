;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Mux_8to1 : 
  module Mux_8to1 : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<8>, flip s0 : UInt<1>, flip s1 : UInt<1>, flip s2 : UInt<1>, out : UInt<1>}
    
    node _Mux4_to_1_a_T = bits(io.in, 3, 3) @[Main.scala 52:59]
    node _Mux4_to_1_a_T_1 = bits(io.in, 2, 2) @[Main.scala 52:73]
    node _Mux4_to_1_a_T_2 = mux(io.s0, _Mux4_to_1_a_T, _Mux4_to_1_a_T_1) @[Main.scala 52:39]
    node _Mux4_to_1_a_T_3 = bits(io.in, 1, 1) @[Main.scala 53:25]
    node _Mux4_to_1_a_T_4 = bits(io.in, 0, 0) @[Main.scala 53:39]
    node _Mux4_to_1_a_T_5 = mux(io.s0, _Mux4_to_1_a_T_3, _Mux4_to_1_a_T_4) @[Main.scala 53:5]
    node Mux4_to_1_a = mux(io.s1, _Mux4_to_1_a_T_2, _Mux4_to_1_a_T_5) @[Main.scala 52:23]
    node _Mux4_to_1_b_T = bits(io.in, 7, 7) @[Main.scala 54:59]
    node _Mux4_to_1_b_T_1 = bits(io.in, 6, 6) @[Main.scala 54:73]
    node _Mux4_to_1_b_T_2 = mux(io.s0, _Mux4_to_1_b_T, _Mux4_to_1_b_T_1) @[Main.scala 54:39]
    node _Mux4_to_1_b_T_3 = bits(io.in, 5, 5) @[Main.scala 55:25]
    node _Mux4_to_1_b_T_4 = bits(io.in, 4, 4) @[Main.scala 55:39]
    node _Mux4_to_1_b_T_5 = mux(io.s0, _Mux4_to_1_b_T_3, _Mux4_to_1_b_T_4) @[Main.scala 55:5]
    node Mux4_to_1_b = mux(io.s1, _Mux4_to_1_b_T_2, _Mux4_to_1_b_T_5) @[Main.scala 54:23]
    node Mux2_to_1 = mux(io.s2, Mux4_to_1_b, Mux4_to_1_a) @[Main.scala 56:21]
    io.out <= Mux2_to_1 @[Main.scala 58:10]
    
