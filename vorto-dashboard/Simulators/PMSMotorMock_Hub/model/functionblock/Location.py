# // Generated by Vorto from org.eclipse.vorto.Location

class Location(object):
    def __init__(self):
        self.latitude = 0.0
        self.longitude = 0.0

    ### Status property latitude
    @property
    def latitude(self):
        return self.__latitude[0]
    
    @latitude.setter
    def latitude(self, value):
        self.__latitude = (value, True)
    
    ### Status property longitude
    @property
    def longitude(self):
        return self.__longitude[0]
    
    @longitude.setter
    def longitude(self, value):
        self.__longitude = (value, True)
    
    def serializeStatus(self, serializer):
        serializer.first_prop = True
        if self.__latitude[1]:
               serializer.serialize_property("latitude", self.__latitude[0])
               self.__latitude = (self.__latitude[0], False)
        if self.__longitude[1]:
               serializer.serialize_property("longitude", self.__longitude[0])
               self.__longitude = (self.__longitude[0], False)
    def serializeConfiguration(self, serializer):
        serializer.first_prop = True