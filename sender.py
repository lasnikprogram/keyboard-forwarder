'''
The following is just a Hello World, to test the connection to my old laptop
The connection is insecure and there is not even a receiver that can use the sent data
Receivers should therefore just use tcpdump or wireshark
'''
import socket
import binascii
import netifaces

# change to mac address of receiver (check: ifconfig):
receiver_mac = '00:00:00:00:00:00'

sock = socket.socket(socket.AF_PACKET, socket.SOCK_RAW)

# change to interface you want to use (check: ifconfig):
interface = 'enp5s0'

source_mac = netifaces.ifaddresses(interface)[netifaces.AF_LINK][0]['addr']
sock.bind((interface, 0))

eth_frame = binascii.unhexlify(receiver_mac.replace(':', '')) + binascii.unhexlify(source_mac.replace(':', ''))
protocol = b'00'
data = b'Hello World!'
sock.send(eth_frame + protocol + data)

sock.close()
