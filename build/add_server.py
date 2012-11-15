#!/usr/bin/env python
import sys
import os
import os.path
import xml.dom.minidom

#if os.environ["TRAVIS_SECURE_ENV_VARS"] == "false":
#  print "no secure env vars available, skipping deployment"
#  sys.exit()

cwd = os.getcwd()
print cwd
m2 = xml.dom.minidom.Document()
settings = m2.createElement("settings")
m2.appendChild(settings)

serversNodes = settings.getElementsByTagName("servers")
if not serversNodes:
  serversNode = m2.createElement("servers")
  settings.appendChild(serversNode)
else:
  serversNode = serversNodes[0]
  
sonatypeServerNode = m2.createElement("server")
sonatypeServerId = m2.createElement("id")
sonatypeServerUser = m2.createElement("username")
sonatypeServerPass = m2.createElement("password")

idNode = m2.createTextNode("sonatype-nexus-snapshots")
userNode = m2.createTextNode(os.environ["SONATYPE_USERNAME"])
passNode = m2.createTextNode(os.environ["SONATYPE_PASSWORD"])

sonatypeServerId.appendChild(idNode)
sonatypeServerUser.appendChild(userNode)
sonatypeServerPass.appendChild(passNode)

sonatypeServerNode.appendChild(sonatypeServerId)
sonatypeServerNode.appendChild(sonatypeServerUser)
sonatypeServerNode.appendChild(sonatypeServerPass)

serversNode.appendChild(sonatypeServerNode)
  
m2Str = m2.toxml()
f = open(cwd + '/settings.xml', 'w')
f.write(m2Str)
f.close()
