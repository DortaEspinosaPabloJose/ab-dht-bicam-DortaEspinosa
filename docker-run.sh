#!/usr/bin/env bash
# Construye la imagen y ejecuta el contenedor de BiCIAM.
set -euo pipefail
docker build -t biciam:latest .
docker run --rm biciam:latest