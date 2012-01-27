LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_C_INCLUDES:= \
	$(call include-path-for,bluez-libs)

LOCAL_CFLAGS:= \
	-DVERSION=\"0.8\" -Wall -DBTL_IF_CLIENT_TEST_ENABLE

LOCAL_C_INCLUDES:= \
	$(call include-path-for, bluez-libs) \
	$(call include-path-for, bluez-utils)/common \
	$(call include-path-for, bluez-utils)/eglib \
	$(call include-path-for, bluez-utils)/gdbus \
	$(call include-path-for, bluez-utils)/sdpd \
	$(call include-path-for, dbus) \
	. $(LOCAL_PATH)/../include \
	. $(LOCAL_PATH)/../../dtun/include \
	system/bluetooth/bluez-clean-headers \

LOCAL_SRC_FILES:= \
	btl_ifc.c \
	btl_ifc_wrapper.c \
	blz_wrapper.c \
	blz20_wrapper.c

LOCAL_SHARED_LIBRARIES := \
	libbluetooth

LOCAL_MODULE_PATH := $(TARGET_OUT_OPTIONAL_EXECUTABLES)
LOCAL_MODULE_TAGS := eng
LOCAL_MODULE:=btlifc

include $(BUILD_EXECUTABLE)