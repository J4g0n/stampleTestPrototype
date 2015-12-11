#!/usr/bin/env bash

SERVER=$1
PATH_TO_KEY=$2

ssh-copy-id -i $SERVER $PATH_TO_KEY