#!/usr/bin/env bash

SERVER=$1
SRC_PATH=$2
DEST_PATH=$3

# usage example: rsync -rtlvazPC -e ssh --progress ~/stampleProject/stampleTestPrototype/ stample-dev:/home/stample/repositories/stampleTestPrototype/
rsync -rtlvazPC -e ssh --progress $SRC_PATH $SERVER:$DEST_PATH
