module MuxLookup(
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
  wire  _io_out_T_1 = 3'h1 == io_sel ? io_in1 : io_in0; // @[Mux.scala 80:57]
  wire  _io_out_T_3 = 3'h2 == io_sel ? io_in2 : _io_out_T_1; // @[Mux.scala 80:57]
  wire  _io_out_T_5 = 3'h3 == io_sel ? io_in3 : _io_out_T_3; // @[Mux.scala 80:57]
  wire  _io_out_T_7 = 3'h4 == io_sel ? io_in4 : _io_out_T_5; // @[Mux.scala 80:57]
  wire  _io_out_T_9 = 3'h5 == io_sel ? io_in5 : _io_out_T_7; // @[Mux.scala 80:57]
  wire  _io_out_T_11 = 3'h6 == io_sel ? io_in6 : _io_out_T_9; // @[Mux.scala 80:57]
  assign io_out = 3'h7 == io_sel ? io_in7 : _io_out_T_11; // @[Mux.scala 80:57]
endmodule
