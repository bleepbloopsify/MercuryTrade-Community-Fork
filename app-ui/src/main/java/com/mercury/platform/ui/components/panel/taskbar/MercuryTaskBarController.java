package com.mercury.platform.ui.components.panel.taskbar;

import com.mercury.platform.shared.store.MercuryStoreCore;
import com.mercury.platform.ui.frame.movable.ItemsGridFrame;
import com.mercury.platform.ui.frame.movable.TaskBarFrame;
import com.mercury.platform.ui.frame.titled.chat.ChatFilterFrame;
import com.mercury.platform.ui.frame.titled.container.HistoryFrame;
import com.mercury.platform.ui.frame.titled.SettingsFrame;
import com.mercury.platform.ui.manager.FramesManager;
import com.mercury.platform.ui.misc.MercuryStoreUI;

public class MercuryTaskBarController implements TaskBarController {
    @Override
    public void enableDND() {
        MercuryStoreUI.repaintSubject.onNext(TaskBarFrame.class);
        MercuryStoreCore.notificationSubject.onNext("DND on");
        MercuryStoreCore.dndSubject.onNext(true);
    }

    @Override
    public void disableDND() {
        MercuryStoreUI.repaintSubject.onNext(TaskBarFrame.class);
        MercuryStoreCore.notificationSubject.onNext("DND off");
        MercuryStoreCore.dndSubject.onNext(false);
    }

    @Override
    public void showITH() {
        FramesManager.INSTANCE.enableOrDisableMovementDirect(ItemsGridFrame.class);
    }

    @Override
    public void performHideout() {
        MercuryStoreCore.chatCommandSubject.onNext("/hideout");
    }

    @Override
    public void showChatFiler() {
        FramesManager.INSTANCE.hideOrShowFrame(ChatFilterFrame.class);
    }

    @Override
    public void showHistory() {
        FramesManager.INSTANCE.hideOrShowFrame(HistoryFrame.class);
    }

    @Override
    public void openPINSettings() {
        FramesManager.INSTANCE.enableMovementExclude(ItemsGridFrame.class);
    }

    @Override
    public void openScaleSettings() {
        FramesManager.INSTANCE.enableScale();
    }

    @Override
    public void showSettings() {
        FramesManager.INSTANCE.showFrame(SettingsFrame.class);
    }

    @Override
    public void exit() {
        FramesManager.INSTANCE.exit();
    }
}
