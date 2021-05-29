#!/bin/sh
sudo -u postgres psql postgres < auditLog.sql
sudo -u postgres psql postgres < statusLog.sql
sudo -u postgres psql postgres < functions.sql
sudo -u postgres psql postgres < triggers.sql
sudo -u postgres psql postgres < mockData.sql
sudo -u postgres psql postgres < usersInit.sql