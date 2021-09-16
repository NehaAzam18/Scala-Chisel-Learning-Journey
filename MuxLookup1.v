module MuxLookup1(
  input        clock,
  input        reset,
  input        io_in0,
  input        io_in1,
  input        io_in2,
  input        io_in3,
  input        io_in4,
  input        io_in5,
  input        io_in6,
  input        io_in7,
  input  [2:0] io_sel,
  output       io_out
);
  wire  _MuxLookup_1_T_3 = 3'h1 == io_sel ? io_in1 : 3'h0 == io_sel & io_in0; // @[Mux.scala 80:57]
  wire  _MuxLookup_1_T_5 = 3'h2 == io_sel ? io_in2 : _MuxLookup_1_T_3; // @[Mux.scala 80:57]
  wire  MuxLookup_1 = 3'h3 == io_sel ? io_in3 : _MuxLookup_1_T_5; // @[Mux.scala 80:57]
  wire  _MuxLookup_2_T_3 = 3'h5 == io_sel ? io_in5 : 3'h4 == io_sel & io_in4; // @[Mux.scala 80:57]
  wire  _MuxLookup_2_T_5 = 3'h6 == io_sel ? io_in6 : _MuxLookup_2_T_3; // @[Mux.scala 80:57]
  wire  MuxLookup_2 = 3'h7 == io_sel ? io_in7 : _MuxLookup_2_T_5; // @[Mux.scala 80:57]
  assign io_out = 3'h1 == io_sel ? MuxLookup_2 : 3'h0 == io_sel & MuxLookup_1; // @[Mux.scala 80:57]
endmodule
