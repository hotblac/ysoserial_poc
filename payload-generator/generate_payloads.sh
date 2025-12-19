#!/bin/bash

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
mkdir -p "$SCRIPT_DIR/target/payloads"

# Payload is base64 encoded contents of the payload class files
base64 "$SCRIPT_DIR/target/classes/org/dontpanic/ysoserial/payload/jackson/TouchFilePayload.class" > "$SCRIPT_DIR/target/payloads/TouchFilePayload.base64.txt"
base64 "$SCRIPT_DIR/target/classes/org/dontpanic/ysoserial/payload/jackson/GnomeCalculatorPayload.class" > "$SCRIPT_DIR/target/payloads/GnomeCalculatorPayload.base64.txt"